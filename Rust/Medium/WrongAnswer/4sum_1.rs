impl Solution {
    pub fn four_sum(nums: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        

        let mut nums = nums;
        nums.sort();
        let mut res = Vec::new();
        for i in 0..nums.len() {
            if i > 0 && nums[i] == nums[i - 1] {
                continue;
            }
            for j in i + 1..nums.len() {
                if j > i + 1 && nums[j] == nums[j - 1] {
                    continue;
                }
                let mut k = j + 1;
                let mut l = nums.len() - 1;
                while k < l {
                    let sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if sum == target {
                        res.push(vec![nums[i], nums[j], nums[k], nums[l]]);
                        while k < l && nums[k] == nums[k + 1] {
                            k += 1;
                        }
                        while k < l && nums[l] == nums[l - 1] {
                            l -= 1;
                        }
                        k += 1;
                        l -= 1;
                    } else if sum < target {
                        k += 1;
                    } else {
                        l -= 1;
                    }
                }
            }
        }
        res
    }
}