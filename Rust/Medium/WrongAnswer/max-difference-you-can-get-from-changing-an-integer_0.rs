impl Solution {
    pub fn max_diff(num: i32) -> i32 {
        
        let mut nums = Vec::new();
        let mut n = num;
        while n > 0 {
            nums.push(n % 10);
            n /= 10;
        }
        let mut a = 0;
        let mut b = 0;
        let mut flag = false;
        for i in (0..nums.len()).rev() {
            if nums[i] == 9 {
                a = a * 10 + 9;
                b = b * 10 + 9;
            } else {
                a = a * 10 + 9;
                b = b * 10 + nums[i];
                flag = true;
            }
        }
        if !flag {
            a = a / 10;
        }
        let mut a = a;
        let mut b = b;
        flag = false;
        for i in (0..nums.len()).rev() {
            if nums[i] == 1 && !flag {
                a = a * 10 + 1;
                b = b * 10 + 1;
            } else {
                a = a * 10 + nums[i];
                b = b * 10 + 1;
                flag = true;
            }
        }
        if !flag {
            a = a / 10;
        }
        a - b
    }
}