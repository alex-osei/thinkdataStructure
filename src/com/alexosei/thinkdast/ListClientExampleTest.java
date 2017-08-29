package com.alexosei.thinkdast;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by alexosei on 8/26/17.
 */
public class ListClientExampleTest {

    @Test
    public void testListClientExample() {
        ListClientExample lce = new ListClientExample();
        @SuppressWarnings("rawtypes")
        List list = lce.getList();
        assertThat(list, instanceOf(ArrayList.class) );
    }
}
