package com.epam.mjc;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        String mySourse = source;
        System.out.println(mySourse);

        for(int i = 0; delimiters.size()>i;i++){
            mySourse=mySourse.replace((CharSequence) delimiters.toArray()[i]," ");
        }

        System.out.println(mySourse);
        String[] res1 = mySourse.split( " ");
        for(int i = 0; res1.length>i;i++){
            res1[i].trim();
        }
        List<String> res = new LinkedList<String>(Arrays.asList(res1));
        res.removeAll(Arrays.asList(""));
        return res;
    }
}
