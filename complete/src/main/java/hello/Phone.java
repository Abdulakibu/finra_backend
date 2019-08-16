package hello;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Phone {

    private final long id;
    private final String content;

    public Phone(long id, String content) {
        this.id = id;
        this.content = content;
        String[] stringArray = content.split(",", -1);
        int[] array = Arrays.stream(stringArray).mapToInt(Integer::parseInt).toArray();
        List<List<Integer>> result = permute(array);
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, nums, result);
        return result;
    }
     
    private void helper(int start, int[] nums, List<List<Integer>> result){
        if(start==nums.length-1){
            ArrayList<Integer> list = new ArrayList<>();
            for(int num: nums){
                list.add(num);
            }
            result.add(list);
            return;
        }
     
        for(int i=start; i<nums.length; i++){
            swap(nums, i, start);
            helper(start+1, nums, result);
            swap(nums, i, start);
        }
    }
     
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
