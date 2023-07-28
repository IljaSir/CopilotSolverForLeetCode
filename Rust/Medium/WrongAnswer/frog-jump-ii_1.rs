impl Solution {
    pub fn max_jump(stones: Vec<i32>) -> i32 {
        
        let mut max = 0;
        for i in 1..stones.len() {
            let diff = stones[i] - stones[i - 1];
            if diff > max {
                max = diff;
            }
        }
        max
    }
    pub fn jump(stones: Vec<i32>) -> i32 {
        let mut max_jump = Self::max_jump(stones.clone());
        let mut left = 1;
        let mut right = max_jump;
        let mut ans = max_jump;
        while left <= right {
            let mut jump = (left + right) / 2;
            let mut last = 0;
            let mut found = true;
            for i in 1..stones.len() {
                if stones[i] - stones[last] < jump {
                    continue;
                }
                if stones[i] - stones[last] > jump {
                    if stones[i] - stones[last] > max_jump {
                        found = false;
                        break;
                    }
                    last = i - 1;
                }
            }
            if found {
                ans = jump;
                right = jump - 1;
            } else {
                left = jump + 1;
            }
        }
        ans
    }
}