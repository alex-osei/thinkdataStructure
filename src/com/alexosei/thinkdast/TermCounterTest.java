package com.alexosei.thinkdast;

/**
 * Created by alexosei on 9/13/17.
 */

import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author downey
 *
 */
public class TermCounterTest {

    private TermCounter counter;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";

        WikiFetcher wf = new WikiFetcher();
        Elements paragraphs = wf.fetchWikipedia(url);

        counter = new TermCounter(url.toString());
        counter.processElements(paragraphs);
    }

    @Test
    public void testSize() {
        assertThat(counter.size(), is(4982));
    }
}
