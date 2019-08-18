package hello;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import com.google.common.collect.Lists;
import com.google.common.base.Functions;
import com.google.common.base.Joiner;

public class Phone {

    private final String[] result;

    public Phone(String result) {
        String[] phoneNumberString = result.split(",", -1);
        int[] phoneNumberInt = Arrays.stream(phoneNumberString).mapToInt(Integer::parseInt).toArray();
        List<List<Integer>> phoneNumberArray = permute(phoneNumberInt);
        List<String> phoneList = Lists.transform(phoneNumberArray, Functions.toStringFunction());
        String[] phoneString = phoneList.toArray(new String[phoneList.size()]);
        String[] phoneReturnValue = new String[phoneString.length];
        for (int i = 0; i < phoneString.length; i++) {
            phoneReturnValue[i] = phoneString[i].replaceAll("[,;\\s\\[|\\]]","");
        }
        this.result = phoneReturnValue;
    }


    public String[] getResult() {
        return result;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        helper(0, nums, results);
        return results;
    }
     
    private void helper(int start, int[] nums, List<List<Integer>> results){
        if(start==nums.length-1){
            ArrayList<Integer> list = new ArrayList<>();
            for(int num: nums){
                list.add(num);
            }
            results.add(list);
            return;
        }
     
        for(int i=start; i<nums.length; i++){
            swap(nums, i, start);
            helper(start+1, nums, results);
            swap(nums, i, start);
        }
    }
     
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
