impl Solution {
    pub fn max_kelements(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut nums = nums;
        let k = k as usize;
        nums.sort();
        let mut max = 0;
        let mut min = 0;
        let mut l = 0;
        let mut r = nums.len() - 1;
        while l <= r {
            let mid = (l + r) / 2;
            let mut sum = 0;
            let mut count = 0;
            for i in 0..nums.len() {
                if nums[i] >= nums[mid] {
                    sum += nums[i] as i64;
                } else {
                    let mut num = nums[i];
                    let mut c = 1;
                    while num < nums[mid] && c <= k - count {
                        num *= 3;
                        c += 1;
                    }
                    if c > k - count {
                        break;
                    }
                    sum += num as i64;
                    count += c;
                }
            }
            if count == k {
                max = sum;
                l = mid + 1;
            } else if count < k {
                max = sum;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        l = 0;
        r = nums.len() - 1;
        while l <= r {
            let mid = (l + r) / 2;
            let mut sum = 0;
            let mut count = 0;
            for i in 0..nums.len() {
                if nums[i] >= nums[mid] {
                    sum += nums[i] as i64;
                } else {
                    let mut num = nums[i];
                    let mut c = 1;
                    while num < nums[mid] && c <= k - count {
                        num *= 3;
                        c += 1;
                    }
                    if c > k - count {
                        break;
                    }
                    sum += num as i64;
                    count += c;
                }
            }
            if count == k {
                min = sum;
                r = mid - 1;
            } else if count < k {
                min = sum;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        max - min
    }
}