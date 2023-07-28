impl Solution {
    pub fn longest_consecutive(nums: Vec<i32>) -> i32 {
        

        let mut set = std::collections::HashSet::new();
        for &num in nums.iter() {
            set.insert(num);
        }
        let mut max_len = 0;
        for &num in set.iter() {
            if !set.contains(&(num - 1)) {
                let mut cur_len = 1;
                let mut cur_num = num + 1;
                while set.contains(&cur_num) {
                    cur_num += 1;
                    cur_len += 1;
                }
                max_len = std::cmp::max(max_len, cur_len);
            }
        }
        max_len
    }
}