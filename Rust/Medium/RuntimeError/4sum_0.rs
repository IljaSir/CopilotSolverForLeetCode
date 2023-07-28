impl Solution {
    pub fn four_sum(nums: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        

        let mut nums = nums;
        nums.sort();
        let mut res = Vec::new();
        for i in 0..nums.len() - 3 {
            if i > 0 && nums[i] == nums[i - 1] {
                continue;
            }
            for j in i + 1..nums.len() - 2 {
                if j > i + 1 && nums[j] == nums[j - 1] {
                    continue;
                }
                let mut l = j + 1;
                let mut r = nums.len() - 1;
                while l < r {
                    let sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if sum == target {
                        res.push(vec![nums[i], nums[j], nums[l], nums[r]]);
                        l += 1;
                        r -= 1;
                        while l < r && nums[l] == nums[l - 1] {
                            l += 1;
                        }
                        while l < r && nums[r] == nums[r + 1] {
                            r -= 1;
                        }
                    } else if sum < target {
                        l += 1;
                    } else {
                        r -= 1;
                    }
                }
            }
        }
        res
    }
}