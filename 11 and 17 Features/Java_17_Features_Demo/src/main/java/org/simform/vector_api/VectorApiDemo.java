package org.simform.vector_api;

import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorSpecies;

public class VectorApiDemo {

    public static int[] addTwoVectorArrays(int[] arr1, int[] arr2) {
        final VectorSpecies<Integer> SPECIES = IntVector.SPECIES_PREFERRED;
        int[] result = new int[arr1.length];
        int i = 0;
        int loopBound = SPECIES.loopBound(arr1.length);
        for (; i < loopBound; i += SPECIES.length()) {
            var mask = SPECIES.indexInRange(i, arr1.length);
            var v1 = IntVector.fromArray(SPECIES, arr1, i, mask);
            var v2 = IntVector.fromArray(SPECIES, arr2, i, mask);
            var additionResult = v1.add(v2, mask);
            additionResult.intoArray(result, i, mask);
        }

        for (; i < arr1.length; i++) {
            result[i] = arr1[i] + arr2[i];
        }
        return result;
    }
}
