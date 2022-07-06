package org.examples;

import java.util.Set;
import java.util.TreeSet;

public abstract class AbstractGenre {
    protected Set<String> trackMusic = new TreeSet<String>();

    AbstractGenre(String... trackMusic) {
        for (String track:trackMusic)
            this.trackMusic.add(track);

    }
}
