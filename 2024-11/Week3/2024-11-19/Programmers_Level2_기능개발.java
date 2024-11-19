import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> progress = new LinkedList<>();
        Queue<Integer> speed = new LinkedList<>();
        Queue<Integer> resultQue = new LinkedList<>();

        int len = progresses.length;
        int[] result;

        // stack 에 progress, speeds 넣기
        for (int i = 0; i < len; i++) {
            progress.add(progresses[i]);
            speed.add (speeds[i]);
        }

        // 루프 돌리기
        int cnt = 0;
        int nowProgress = 0;
        int nowProgressIndex = 0;
        int days = 1;
        int resultInd = 0;

        while (!progress.isEmpty()) {
            // Queue 에서 값 빼기
            nowProgress = progress.element();
            int nowSpeed = speed.element();

            int remain = 100 - nowProgress;
            // 최소 day 값 세기
            if (cnt == 0) {
                days = remain / nowSpeed;
                if (remain % nowSpeed > 0) { days += 1;}
                progress.remove();
                speed.remove();
                cnt++;
            }
            // 다음 작업이 이미 끝난 경우
            else if (nowProgress + (days * nowSpeed) >= 100) {
                progress.remove();
                speed.remove();
                cnt++;
            }


            if (cnt != 0 
                && progress.isEmpty() 
                || nowProgress + (days * nowSpeed) < 100) {
                resultQue.add(cnt);
                cnt = 0;
            }

        }
        int i = 0;
        result = new int[resultQue.size()];
        while (!resultQue.isEmpty()) {
            if (resultQue.element() == 0) {return result; }
            else {
                result[i] = resultQue.remove();
                i++;
            }
        }

        return result;
    }
}