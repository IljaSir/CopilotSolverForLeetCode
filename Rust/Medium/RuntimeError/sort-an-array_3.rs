impl Solution {
    pub fn sort_array(nums: Vec<i32>) -> Vec<i32> {
        
        // Sort the array using quick sort
        let mut nums = nums;
        let len = nums.len();
        Self::quick_sort(&mut nums, 0, len - 1);
        nums
    }
    
    fn quick_sort(nums: &mut Vec<i32>, left: usize, right: usize) {
        if left >= right {
            return;
        }
        let pivot = nums[left];
        let mut i = left + 1;
        let mut j = right;
        while i <= j {
            while i <= j && nums[i] < pivot {
                i += 1;
            }
            while i <= j && nums[j] > pivot {
                j -= 1;
            }
            if i < j {
                nums.swap(i, j);
                i += 1;
                j -= 1;
            } else {
                break;
            }
        }
        nums.swap(left, j);
        Self::quick_sort(nums, left, j - 1);
        Self::quick_sort(nums, j + 1, right);
    }
}