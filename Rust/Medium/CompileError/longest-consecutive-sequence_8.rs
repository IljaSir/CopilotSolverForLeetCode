impl Solution {
    pub fn longest_consecutive(nums: Vec<i32>) -> i32 {
        

        let mut max_len = 0;
        let mut num_set: std::collections::HashSet<i32> = std::collections::HashSet::new();
        for num in nums {
            num_set.insert(num);
        }
        for num in nums {
            if !num_set.contains(&(num - 1)) {
                let mut cur_num = num;
                let mut cur_len = 1;
                while num_set.contains(&(cur_num + 1)) {
                    cur_len += 1;
                    cur_num += 1;
                }
                max_len = max_len.max(cur_len);
            }
        }
        max_len
    }
}