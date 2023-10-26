import org.junit.jupiter.api.Test;
import spock.lang.Specification;
import org.mockito.Mockito;
import com.aor.numbers.GenericListDeduplicator;
import com.aor.numbers.GenericListSorter;

class FirstSpecification extends Specification{
    def "one plus one should equal two"() {
        expect:
        1 + 1 == 2
    }

    def "two plus two should equal four"() {
        given:
        int left = 2
        int right = 2
        when:
        int result = left + right
        then:
        result == 4
    }
    def "Should be able to remove from list"() {
        given:
        def list = [1, 2, 3, 4]
        when:
        list.remove(0)
        then:
        list == [2, 3, 4]
    }
    def "Should get an index out of bounds when removing a non-existent item"() {
        given:
        def list = [1, 2, 3, 4]
        when:
        list.remove(20)
        then:
        thrown(IndexOutOfBoundsException)
        list.size() == 4
    }
    def "numbers to the power of two"(int a, int b, int c) {
        expect:
        Math.pow(a, b) == c
        where:
        a | b | c
        1 | 2 | 1
        2 | 2 | 4
        3 | 2 | 9
    }
    def "distinct_bug_8726"(){
        given:
        def deduplicator = Mock(GenericListDeduplicator)
        deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2)) >>
                Arrays.asList(1, 2, 4)
        when:
        def result = deduplicator.deduplicate(Arrays.asList(1, 2,
                4, 2))
        then:
        result == Arrays.asList(1,2,4)
    }
    def "true_always"(){
        given:
        def deduplicator = Mock(GenericListDeduplicator)
        deduplicator.deduplicate(_) >> Arrays.asList(1, 2, 4)
    }
    def "different"(){
        given:
        def deduplicator = Mock(GenericListDeduplicator)
        deduplicator.deduplicate(_) >>> [Arrays.asList(1, 2, 4), Arrays.asList(6, 7)]
    }
    def "Should verify notify was called"() {
        given:
        def notifier = Mock(Notifier)
        when:
        notifier.notify('foo')
        then:
        1 * notifier.notify('foo')
    }

}
