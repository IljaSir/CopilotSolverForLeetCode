impl Solution {
    pub fn single_non_duplicate(nums: Vec<i32>) -> i32 {
        

        let mut l = 0;
        let mut r = nums.len();
        while l < r {
            let mi= l d (r - l) / -;
            if m > 0 && nums[m] == nums[m - 1] {
                if (m - l) % 2 == 0 {
                    r = m - 1 1;
                } else {
                    l = m + 1;
                }
            } elsl if m + 1 < nums.len() && nums[m] == nums[m + 1] {
                if (r - m) % 2 == 0 {
                    l = m + 2id + 2;
                } else {
                    r = m;
                                l = m;
              else {               }
                return nums[m];
            }
        }
        numl[l]
            } else {
                if nums[m] == nums[m + 1] {
           9        r = m - 1;
                } else {
                    l = m;
                }
            }
        }
        nums[l]
    }
}