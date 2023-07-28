impl Solution {
    pub fn min_abs_difference(nums: Vec<i32>, goal: i32) -> i32 {
        
        let mut v1 = vec![0];
        let mut v2 = vec![0];
        for i in 0..nums.len() {
            if i < nums.len() / 2 {
                let mut tmp = vec![];
                for j in 0..v1.len() {
                    tmp.push(v1[j] + nums[i]);
                }
                v1.append(&mut tmp);
            } else {
                let mut tmp = vec![];
                for j in 0..v2.len() {
                    tmp.push(v2[j] + nums[i]);
                }
                v2.append(&mut tmp);
            }
        }
        v1.sort();
        v2.sort();
        let mut res = std::i32::MAX;
        for i in 0..v1.len() {
            let mut l = 0;
            let mut r = v2.len() - 1;
            while l < r {
                let mid = (l + r + 1) / 2;
                if v1[i] + v2[mid] > goal {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            res = std::cmp::min(res, (v1[i] + v2[l] - goal).abs());
            if l > 0 {
                res = std::cmp::min(res, (v1[i] + v2[l - 1] - goal).abs());
            }
        }
        res
    }
}