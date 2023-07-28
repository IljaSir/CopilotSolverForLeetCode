impl Solution {
    pub fn count_good(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut count = 0;
        let mut s = vec![];
        let mut res = 0;
        let mut i = 0;
        while i < nums.len() {
            let mut j = i;
            while j < nums.len() && nums[i] == nums[j] {
                j += 1;
            }
            for _ in 0..j - i {
                if s.len() < k as usize {
                    s.push(nums[i]);
                } else {
                    count -= 1;
                    s.remove(0);
                    s.push(nums[i]);
                }
                if s.len() == k as usize {
                    count += 1;
                    res += count;
                }
            }
            i = j;
        }
        res
    }
}