impl Solution {
    pub fn max_jump(stones: Vec<i32>) -> i32 {
        
        let mut max_jump = 0;
        for i in 1..stones.len() {
            let jump = stones[i] - stones[i - 1];
            if jump > max_jump {
                max_jump = jump;
            }
        }
        max_jump
    }
    pub fn can_reach(stones: &Vec<i32>, k: i32, current: usize, max_jump: i32) -> bool {
        if current == stones.len() - 1 {
            return true;
        }
        for i in 1..k + 1 {
            if current + i < stones.len() && stones[current + i] - stones[current] <= max_jump {
                if Solution::can_reach(stones, i, current + i, max_jump) {
                    return true;
                }
            }
        }
        false
    }
    pub fn frog_jump(stones: Vec<i32>) -> i32 {
        let max_jump = Solution::max_jump(stones.clone());
        let mut k = 0;
        for i in 1..stones.len() {
            if stones[i] - stones[i - 1] > k {
                k = stones[i] - stones[i - 1];
            }
        }
        let mut min_k = 1;
        let mut max_k = k;
        while min_k < max_k {
            let mid = (min_k + max_k) / 2;
            if Solution::can_reach(&stones, mid, 0, max_jump) {
                max_k = mid;
            } else {
                min_k = mid + 1;
            }
        }
        max_k
    }
}