package com.alexosei.thinkdast;

/**
 * Created by alexosei on 9/1/17.
 */

import com.alexosei.thinkdast.Profiler.Timeable;
import org.jfree.data.xy.XYSeries;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProfileListAdd {

    /**
     * @param args
     */
    public static void main(String[] args) {
        profileArrayListAddEnd();
        profileArrayListAddBeginning();
        profileLinkedListAddBeginning();
        profileLinkedListAddEnd();
    }

    /**
     * Characterize the run time of adding to the end of an ArrayList
     */
    public static void profileArrayListAddEnd() {
        Timeable timeable = new Timeable() {
            List<String> list;

            public void setup(int n) {
                list = new ArrayList<String>();
            }

            public void timeMe(int n) {
                for (int i=0; i<n; i++) {
                    list.add("a string");
                }
            }
        };
        int startN = 4000;
        int endMillis = 1000;
        runProfiler("ArrayList add end", timeable, startN, endMillis);
    }

    /**
     * Characterize the run time of adding to the beginning of an ArrayList
     */
    public static void profileArrayListAddBeginning() {
        // TODO: FILL THIS IN!
        Timeable timeable = new Timeable() {
            List<String> list;

            public void setup(int n){
                list = new ArrayList<String>();
            }

            public void timeMe(int n){
                for(int i = 0; i < n; i++){
                    list.add(0, "a string");
                }
            }
        };
        int startN = 4000;
        int endMills = 10000;
        runProfiler("ArrayList add beginning", timeable, startN, endMills);
    }

    /**
     * Characterize the run time of adding to the beginning of a LinkedList
     */
    public static void profileLinkedListAddBeginning() {
        // TODO: FILL THIS IN!

        Timeable timeable = new Timeable() {

            List<String> list;

            public void setup(int n) {

                list = new LinkedList<String>();
            }


            public void timeMe(int n) {
                for(int i = 0; i < n; i++){
                    list.add(0, "a string");
                }
            }
        };

        int startN = 128000;
        int endMills = 2000;
        runProfiler("Linkedlist add beginning", timeable, startN, endMills);
    }

    /**
     * Characterize the run time of adding to the end of a LinkedList
     */
    public static void profileLinkedListAddEnd() {
        // TODO: FILL THIS IN!

        Timeable timeable = new Timeable() {
            List<String> list;

            public void setup(int n) {
                list = new LinkedList<String>();
            }

            public void timeMe(int n) {
                for(int i = 0; i < n; i++){
                    list.add("a string");
                }
            }
        };

        int startN = 64000;
        int endMills = 1000;
        runProfiler("Linkedlist add end", timeable, startN, endMills);
    }

    /**
     * Runs the profiles and displays results.
     *
     * @param timeable
     * @param startN
     * @param endMillis
     */
    private static void runProfiler(String title, Timeable timeable, int startN, int endMillis) {
        Profiler profiler = new Profiler(title, timeable);
        XYSeries series = profiler.timingLoop(startN, endMillis);
        profiler.plotResults(series);
    }
}