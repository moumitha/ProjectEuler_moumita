package com.moumita.ProjectEuler;

import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import static java.util.Arrays.stream;
/*

 * Maximum path sum II
 * Problem 67
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum
 * total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

 * That is, 3 + 7 + 4 + 9 = 23.

 * Find the maximum total from top to bottom in triangle.txt (right click and 'Save Link/Target As...'),
 * a 15K text file containing a triangle with one-hundred rows.

 * NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route to solve this problem,
 * as there are 299 altogether! If you could check one trillion (1012) routes every second it would take over twenty
 * billion years to check them all. There is an efficient algorithm to solve it. ;o)

 */

public class MaxPathSumII_euler67 {

    public static int printMaxPathSum(int[][] triangleData) {

        for (int i = triangleData.length - 1; i > 0; i--)
            for (int j = 0; j< triangleData[i].length - 1; j++)
                triangleData[i - 1][j] += Math.max(triangleData[i][j], triangleData[i][j + 1]);

        return triangleData[0][0];
    }

    public int[][] setupFileResource(String fileName) throws IOException {
        return Files.lines(Paths.get(fileName))
                .map(s -> stream(s.trim().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .toArray(int[][]::new);
    }

    @Test
    public void TestMaxPathSum() throws IOException {
        int[][] rows = setupFileResource("p067_triangle.txt");

        long startTime = System.currentTimeMillis();
        Assert.assertEquals(printMaxPathSum(rows), 7273);
        System.out.println("Estimated elapsed time: " + (System.currentTimeMillis() - startTime)); //70ms
    }

    @Test
    public void TestMaxPathSumWithSmallTriangle() throws IOException {
        int[][] rows = setupFileResource("p067_small_triangle.txt");

        long startTime = System.currentTimeMillis();
        Assert.assertEquals(printMaxPathSum(rows), 23);
        System.out.println("Estimated elapsed time: " + (System.currentTimeMillis() - startTime)); //0s
    }


}
