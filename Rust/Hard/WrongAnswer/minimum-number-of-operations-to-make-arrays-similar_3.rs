impl Solution {
    pub fn make_similar(nums: Vec<i32>, target: Vec<i32>) -> i64 {
        
        let mut diff = Vec::new();
        for i in 0..nums.len() {
            let d = nums[i] - target[i];
            if d != 0 {
                diff.push(d);
            }
        }
        diff.sort();
        let mut i = 0;
        let mut j = diff.len() - 1;
        let mut res = 0;
        while i < j {
            let mut k = 1;
            while i + k < j && diff[i + k] + diff[j] == 0 {
                k += 1;
            }
            if i + k >= j {
                res += 1;
                break;
            }
            if diff[i] + diff[j] == 0 {
                res += 1;
                i += k;
                j -= 1;
            } else if diff[i] + diff[j] > 0 {
                res += 1;
                j -= 1;
            } else {
                res += 1;
                i += k;
            }
        }
        if i == j {
            res += 1;
        }
        res
    }
}