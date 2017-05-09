package java8;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;
import java.util.function.Predicate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PredicateTests
{

	@Test
	public void testPredicates() {
		Predicate<String> predicate = (s) -> s.length() > 0;

		assertTrue( predicate.test("foo") );
		assertFalse( predicate.negate().test("foo") );

		Predicate<Boolean> nonNull = Objects::nonNull;
		Predicate<Boolean> isNull = Objects::isNull;

		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();


	}

}
