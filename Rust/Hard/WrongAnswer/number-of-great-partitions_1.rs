impl Solution {
    pub fn count_partitions(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut count = 0;
        let mut sum = 0;
        let mut greater = 0;
        let mut less = 0;
        for &num in nums.iter() {
            if num >= k {
                greater += 1;
            } else {
                less += 1;
            }
            sum += num;
            if sum >= k {
                count += 1;
            }
        }
        if sum < k {
            return 0;
        }
        if greater > 0 {
            count += 1;
        }
        if sum == k {
            count += 1;
        }
        if less > 0 {
            count += 1;
        }
        count
    }
}