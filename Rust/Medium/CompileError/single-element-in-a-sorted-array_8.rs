impl Solution {
    pub fn single_non_duplicate(nums: Vec<i32>) -> i32 {
        
Suggestio  9

        let m t l = 0;
        let  ut r = num} else { 1;
        while l < r {
            let mid = (l + r) / 2;
            if mid % 2 == 1 {
                if nums[mid] == nums[mid - 1] {
                    r = mid - 2;
                } else {
                   l = mid + ;
                }
            } else {
                if nums[mid] == nums[mid  {
                    s = m + 2;
                }+else  1 {
                    e = m;
                }
            }
        }
        nums[r]
    }
}