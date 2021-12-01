package me.hopedev.aoc;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringEscapeUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class SonarSweep {

    public static void main(String[] args) throws IOException {


        final int[] matches = new int[1];
        final int[] lastSweep = new int[1];
        String[] lines = FileUtils.readFileToString(new File("input.txt"), StandardCharsets.UTF_8).split("\n");

        Arrays.stream(lines).iterator().forEachRemaining(s -> {
            String curr = s.replaceAll("\r", "");
            int sweep = Integer.parseInt(curr);

           if (sweep > lastSweep[0]) {
               System.out.println(sweep+" (increased from "+lastSweep[0]+")");
                lastSweep[0] = sweep;
                matches[0]++;
            } else {
               System.out.println(sweep + " (decreased from "+lastSweep[0]+")");
               lastSweep[0] = sweep;
           }
        });


        System.out.println("Finished! Total matches: "+(matches[0]-1));
    }

}
