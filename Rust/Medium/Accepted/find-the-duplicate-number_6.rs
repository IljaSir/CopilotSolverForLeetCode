impl Solution {
    pub fn find_duplicate(nums: Vec<i32>) -> i32 {
        

        let mut nums = nums;
        let mut slow = 0;
        let mut fast = 0;
        loop {
            slow = nums[slow] as usize;
            fast = nums[nums[fast] as usize] as usize;
            if slow == fast {
                break;
            }
        }
        let mut ptr1 = 0;
        let mut ptr2 = slow;
        while ptr1 != ptr2 {
            ptr1 = nums[ptr1] as usize;
            ptr2 = nums[ptr2] as usize;
        }
        ptr1 as i32
    }
}