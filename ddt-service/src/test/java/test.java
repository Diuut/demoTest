
import com.diuut.ddt.application;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author Diuut
 * @Date 2020/9/8  16:32
 */
@SpringBootTest(classes = application.class)
@Slf4j
public class test {
    @Test
    public void test1() {
        log.info("hello world");
    }

    @Test
    public void test2() {
       String test="123456";
        System.out.println(test.indexOf("87"));
    }


    public void printTst(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(" "+nums[i]);
        }
        System.out.println("");
    }


    //归并算法
    @Test
    public void 归并排序() {
        int[] nums= {12,32,44,55,65,23,4,12,67,99,43,1,51};
        printTst(nums);
        int[] result=new int[nums.length];
        //归并排序
        this.mergeSort(nums,0,nums.length-1,result);
        //此时nums与result相同
        printTst(nums);
    }
    private void mergeSort(int[] nums,int start,int end,int[] result){
        // 只剩下一个数字，停止拆分
        if(start==end) return;
        int middle=(start+end)/2;
        // 拆分左边区域，并将归并排序的结果保存到 result 的 [start, middle] 区间
        mergeSort(nums,start,middle,result);
        // 拆分右边区域，并将归并排序的结果保存到 result 的 [middle + 1, end] 区间
        mergeSort(nums,middle+1,end,result);
        // 合并左右区域到 result 的 [start, end] 区间
        merge(nums,start,end,result);
    }
    public void merge(int[] nums,int start,int end,int[] result){
        //分割
        int middle=(start+end)/2;
        // 数组 1 的首尾位置
        int start1=start;
        int end1=middle;
        // 数组 2 的首尾位置
        int start2=middle+1;
        int end2=end;
        // 用来遍历数组的指针
        int index1=start1;
        int index2=start2;
        // 结果数组的指针
        int resultIndex=start1;
        //比较插入结果数组
        while(index1<=end1 && index2<=end2){
            if(nums[index1]<=nums[index2]){
                result[resultIndex++]=nums[index1++];
            }else{
                result[resultIndex++]=nums[index2++];
            }
        }
        // 将剩余数字补到结果数组之后
        while(index1<=end1){
            result[resultIndex++]=nums[index1++];
        }
        while(index2<=end2){
            result[resultIndex++]=nums[index2++];
        }
        // 将 result 操作区间的数字拷贝到 arr 数组中，以便下次比较
        for(int i=start;i<=end;i++){
            nums[i]=result[i];
        }
    }



}
