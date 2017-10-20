package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by SZ on 2017/9/1.
 */
public class CourseSchedule {

    public static void main(String[] args) {
        CourseSchedule c = new CourseSchedule();
        int[][] nums = {{1, 0}};
        System.out.println(c.canFinish(2, nums));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Vertex[] vertices = new Vertex[numCourses];
        for (int i = 0; i < numCourses; i++) {
            vertices[i] = new Vertex(i);
        }
        for(int[] edge : prerequisites) {
            vertices[edge[0]].inDegree++;
            vertices[edge[1]].adjacent.add(vertices[edge[0]]);
        }
        Queue<Vertex> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(vertices[i].inDegree == 0) {
                q.offer(vertices[i]);
            }
        }
        int count = 0;
        while(!q.isEmpty()) {
            Vertex v = q.poll();
            count++;
            for(Vertex w : v.adjacent) {
                if(--w.inDegree == 0) {
                    q.offer(w);
                }
            }
        }
        return count == numCourses;
    }

    class Vertex {
        int value;
        int inDegree;
        List<Vertex> adjacent;

        public Vertex(int value) {
            this.value = value;
            this.adjacent = new LinkedList<>();
        }
    }
}
