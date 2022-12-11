import java.util.*;

public class Solution {
    private static class Job {
        public final int start;
        public final int duration;

        private Job(int start, int duration) {
            this.start = start;
            this.duration = duration;
        }
    }

    public int solution(int[][] rawJobs) {
        Job[] jobs = new Job[rawJobs.length];
        for (int i = 0; i < jobs.length; i++) {
            jobs[i] = new Job(rawJobs[i][0], rawJobs[i][1]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(job -> job.start));

        Queue<Job> q = new LinkedList<>(Arrays.asList(jobs));
        PriorityQueue<Job> pq = new PriorityQueue<>(
                Comparator.comparingInt(job -> job.duration));

        int exec = 0;
        int time = 0;
        while (!q.isEmpty() || !pq.isEmpty()) {
            while (!q.isEmpty() && q.peek().start <= time) {
                pq.add(q.poll());
            }

            if (pq.isEmpty()) {
                time = q.peek().start;
                continue;
            }

            Job job = pq.poll();
            exec += time + job.duration - job.start;
            time += job.duration;
        }

        return exec / jobs.length;
    }
}
