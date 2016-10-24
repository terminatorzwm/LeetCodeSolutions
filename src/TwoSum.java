/**
 * Created by z00195317 on 2016/10/24.
 */
import java.util.HashMap;
import java.util.Map;
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = 0;
        Map<Integer, Integer> numberMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            Integer diff = target - numbers[i];
            if (null != numberMap.get(diff)) {
                index1 = i + 1;
                index2 = numberMap.get(diff) + 1;
                if (index1 != index2) {
                    if (index1 > index2) {
                        int tmp = index1;
                        index1 = index2;
                        index2 = tmp;
                    }
                    break;
                }
            }else {
                numberMap.put(numbers[i], i);
            }
        }
        int[] result = {index1, index2};
        return result;
    }
}
