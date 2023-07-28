impl Solution {
    pub fn ways_to_make_fair(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut odd = vec![0; n];
        let mut even = vec![0; n];
        for i in 0..n {
            if i % 2 == 0 {
                even[i] = nums[i];
            } else {
                odd[i] = nums[i];
            }
        }
        for i in 1..n {
            odd[i] += odd[i-1];
            even[i] += even[i-1];
        }
        let mut res = 0;
        for i in 0..n {
            if i == 0 {
                if even[n-1] - even[0] == odd[n-2] {
                    res += 1;
                }
            } else if i == n-1 {
                if odd[n-2] == even[n-2] {
                    res += 1;
                }
            } else {
                if even[i-1] + odd[n-1] - odd[i] == odd[i-1] + even[n-1] - even[i] {
                    res += 1;
                }
            }
        }
        res
    }
}