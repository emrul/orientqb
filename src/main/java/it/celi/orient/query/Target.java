package it.celi.orient.query;

import com.google.common.collect.Lists;
import it.celi.orient.util.Commons;
import it.celi.orient.util.Joiner;

import java.util.Collection;

/**
 * Created by rayman on 31/12/14.
 */
public class Target {

    public static final Target DEFAULT = new Target("V");

    private final String target;

    public Target(String target) {
        this.target = target;
    }

    public static Target target(String target) {
        return new Target(target);
    }

    public static Target target(String ... targets) {
        return new Target(Commons.arrayToString(targets));
    }

    public static Target cluster(int cluster) {
        return new Target("cluster:" + Integer.toString(cluster));
    }

    public static Target indexValues(String indexName) {
        return new Target("indexvalues:" + indexName);
    }

    public static Target indexValuesAsc(String indexName) {
        return new Target("indexvaluesasc:" + indexName);
    }

    public static Target indexValuesDesc(String indexName) {
        return new Target("indexvaluesdesc:" + indexName);
    }

    public String toString() {
        return this.target;
    }
}