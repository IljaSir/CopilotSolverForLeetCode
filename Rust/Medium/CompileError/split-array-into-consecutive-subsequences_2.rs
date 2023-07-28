impl Solution {
    pub fn is_possible(nums: Vec<i32>) -> bool {
        

        let mut cnt = vec![0; 10001];
        let mut tails = vec![0; 10001];
        for num in nums {
            cnt[num as usize] += 1;
        }
        for num in nums {
            if cnt[num as usize] == 0 {
                continue;
            } else if tails[num as usize - 1] > 0 {
                tails[num as usize - 1] -= 1;
                tails[num as usize] += 1;
            } else if cnt[num as usize + 1] > 0 && cnt[num as usize + 2] > 0 {
                cnt[num as usize + 1] -= 1;
                cnt[num as usize + 2] -= 1;
                tails[num as usize + 2] += 1;
            } else {
                return false;
            }
            cnt[num as usize] -= 1;
        }
        true
    }
}