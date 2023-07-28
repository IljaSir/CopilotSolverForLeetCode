impl Solution {
    pub fn is_possible(nums: Vec<i32>) -> bool {
        

        let mut nums = nums;
        let mut arr = vec![];
        let mut i = 0;
        while i < nums.len() {
            let mut j = i;
            while j < nums.len() && nums[i] == nums[j] {
                j += 1;
            }
            let mut k = i;
            while k < j {
                let mut l = 0;
                while l < arr.len() && (arr[l][0] != nums[i] || arr[l][1] == 0) {
                    l += 1;
                }
                if l == arr.len() {
                    arr.push(vec![nums[i], j - k]);
                } else {
                    arr[l][1] += j - k;
                }
                k += 1;
            }
            i = j;
        }
        for i in 0..arr.len() {
            if arr[i][1] < 3 {
                return false;
            }
        }
        true
    }
}