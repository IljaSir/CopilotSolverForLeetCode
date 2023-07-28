impl Solution {
    pub fn find_pairs(nums: Vec<i32>, k: i32) -> i32 {
        

        let mut cnt = 0;
        let mut set = std::collections::HashSet::new();
        if k < 0 {
            return 0;
        }
        if k == 0 {
            for num in nums {
                if set.contains(&num) {
                    cnt += 1;
                    set.remove(&num);
                } else {
                    set.insert(num);
                }
            }
            return cnt;
        }
        for num in nums {
            if set.contains(&(num - k)) {
                cnt += 1;
            }
            if set.contains(&(num + k)) {
                cnt += 1;
            }
            set.insert(num);
        }
        cnt / 2
    }
}