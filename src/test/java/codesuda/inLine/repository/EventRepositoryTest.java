package codesuda.inLine.repository;

import codesuda.inLine.constant.EventStatus;
import codesuda.inLine.constant.PlaceType;
import codesuda.inLine.domain.Event;
import codesuda.inLine.domain.Place;
import com.querydsl.core.BooleanBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class EventRepositoryTest {

    private final EventRepository sut;
    private final TestEntityManager testEntityManager;

    EventRepositoryTest(@Autowired EventRepository sut, @Autowired TestEntityManager testEntityManager) {
        this.sut = sut;
        this.testEntityManager = testEntityManager;
    }

    @DisplayName("ffff")
    @Test
    void test() {
        //given
        Place place = createPlace();
        Event event = createEvent(place);
        testEntityManager.persist(place);
        testEntityManager.persist(event);

        //when
        Iterable<Event> events = sut.findAll(new BooleanBuilder());

        //then
        assertThat(events).hasSize(7);
    }

    private Event createEvent(Place place) {
        return createEvent(place, "Test Event", EventStatus.CANCELLED,
                LocalDateTime.now(), LocalDateTime.now());
    }

    private Event createEvent(
            Place place,
            String eventName,
            EventStatus eventStatus,
            LocalDateTime eventStartDateTime,
            LocalDateTime eventEndDateTime
    ) {
        return Event.of(
                place,
                eventName,
                eventStatus,
                eventStartDateTime,
                eventEndDateTime,
                0,
                24,
                "마스크 꼭 착용하세요"
        );

    }

    private Place createPlace() {
        return Place.of(PlaceType.COMMON, "test place", "test address", "010-1234-1234", 10, null);
    }
}