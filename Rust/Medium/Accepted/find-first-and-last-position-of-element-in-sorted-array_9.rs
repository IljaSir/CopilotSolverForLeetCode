impl Solution {
    pub fn search_range(nums: Vec<i32>, target: i32) -> Vec<i32> {
        

        let mut begin = 0;
        let mut end = nums.len();
        let mut mid = 0;
        let mut result = vec![-1, -1];
        while begin < end {
            mid = (begin + end) / 2;
            if nums[mid] < target {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        if begin == nums.len() || nums[begin] != target {
            return result;
        }
        result[0] = begin as i32;
        end = nums.len();
        while begin < end {
            mid = (begin + end) / 2;
            if nums[mid] > target {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        result[1] = end as i32 - 1;
        result
    }
}