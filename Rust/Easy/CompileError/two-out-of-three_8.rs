impl Solution {
    pub fn two_out_of_three(nums1: Vec<i32>, nums2: Vec<i32>, nums3: Vec<i32>) -> Vec<i32> {
        
        let mut all = nums1;
        all.extend(nums2);
        all.extend(nums3);
        let mut cnt = [0; 101];
        for i in all {
            cnt[i as usize] += 1;
        }
        let mut res = Vec::new();
        for i in 1..101 {
            if cnt[i] > 1 {
                res.push(i);
            }
        }
        res
    }
}