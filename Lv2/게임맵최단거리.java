import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int height = maps.length;
        int width = maps[0].length;
        
        int[] node = new int[2];
        boolean[][] visited = new boolean[height][width];
        int[][] distance = new int[height][width];
        Queue<int[]> q = new LinkedList<int[]>();
        
        node[0] = 0; node[1] = 0;
        q.add(node);
        visited[0][0] = true;
        distance[0][0] = 1;
        
        int[] now;
        boolean flag = false;
        while (q.size() > 0) {
            now = q.poll();
            
            if (now[0] == height-1 && now[1] == width-1) {
                flag = true;
                answer = distance[now[0]][now[1]];
                break;
            }
            
            // 상
            if ((now[0]-1 >= 0) && (maps[now[0]-1][now[1]] == 1)
               && (!visited[now[0]-1][now[1]])) {
                visited[now[0]-1][now[1]] = true;
                int[] next = { now[0]-1, now[1] };
                q.add(next);
                distance[now[0]-1][now[1]] = distance[now[0]][now[1]] + 1;
            }
            // 하
            if ((now[0]+1 <= height-1) && (maps[now[0]+1][now[1]] == 1)
               && (!visited[now[0]+1][now[1]])) {
                visited[now[0]+1][now[1]] = true;
                int[] next = { now[0]+1, now[1] };
                q.add(next);
                distance[now[0]+1][now[1]] = distance[now[0]][now[1]] + 1;
            }
            // 좌
            if ((now[1]-1 >= 0) && (maps[now[0]][now[1]-1] == 1)
               && (!visited[now[0]][now[1]-1])) {
                visited[now[0]][now[1]-1] = true;
                int[] next = { now[0], now[1]-1 };
                q.add(next);
                distance[now[0]][now[1]-1] = distance[now[0]][now[1]] + 1;
            }
            // 우
            if ((now[1]+1 <= width-1) && (maps[now[0]][now[1]+1] == 1)
               && (!visited[now[0]][now[1]+1])) {
                visited[now[0]][now[1]+1] = true;
                int[] next = { now[0], now[1]+1 };
                q.add(next);
                distance[now[0]][now[1]+1] = distance[now[0]][now[1]] + 1;
            }
        }
        
        if (!flag)
            answer = -1;
        
        return answer;
    }
}
