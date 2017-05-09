package java8;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OptionalTests
{
    //
    // Java 8 Optional provides a mechanism to d
    //

	@Test
	public void testOptional_basic_uses() {
		Optional<String> optional = Optional.of("bam");

		assertTrue( optional.isPresent() );
		assertEquals( "bam", optional.get() );
		assertEquals( "bam", optional.orElse("fallback") );


		optional = Optional.empty();
		assertFalse( optional.isPresent() );
        assertEquals( "fallback", optional.orElse("fallback") );

		optional.ifPresent((s) -> System.out.println(s.charAt(0))); // "b"
	}

    /**
     * can't call .get() on a non-initialized Optional
     */
	@Test( expected = NoSuchElementException.class )
    public void testOptionalException()
    {
        Optional optional = Optional.empty();
        optional.get();
    }

    /**
     *  isPresent vs ifPresent
     */
    @Test
    public void testOptional_with_lamda()
    {
        Optional stringToUse1 = Optional.of( "optional is there" );
        if( stringToUse1.isPresent() )
        {
            System.out.println( stringToUse1.get() );
        }

        /* above is functionally equivalent to below, but more concise */

        Optional stringToUse2 = Optional.of( "optional is there" );
        stringToUse2.ifPresent( System.out::println );
    }

    @Test
    public void testOptional_and_throw_exception()
    {
        try
        {
            Optional optionalCarNull = Optional.ofNullable(null);
            optionalCarNull.orElseThrow(IllegalStateException::new);

            Assert.fail();
        } catch ( Throwable e )
        {
            ; // expected result
        }
    }
}
