impl Solution {
    pub fn max_diff(num: i32) -> i32 {
        
        let mut max = 0;
        let mut min = 0;
        let mut first = true;
        let mut max_flag = false;
        let mut min_flag = false;
        let mut max_count = 0;
        let mut min_count = 0;
        let mut num = num;
        while num > 0 {
            let mut tmp = num % 10;
            if first {
                if tmp == 9 {
                    tmp = 1;
                } else {
                    tmp = 9;
                    max_flag = true;
                }
                if tmp == 0 {
                    tmp = 1;
                    min_flag = true;
                } else {
                    tmp = 0;
                }
                first = false;
            } else {
                if max_flag {
                    tmp = 9;
                    max_count += 1;
                } else {
                    tmp = 1;
                    max_count += 1;
                }
                if min_flag {
                    tmp = 0;
                    min_count += 1;
                } else {
                    tmp = 1;
                    min_count += 1;
                }
            }
            max = max * 10 + tmp;
            min = min * 10 + tmp;
            num = num / 10;
        }
        let mut max_count = max_count;
        while max_count > 0 {
            max = max / 10;
            max_count -= 1;
        }
        let mut min_count = min_count;
        while min_count > 0 {
            min = min / 10;
            min_count -= 1;
        }
        max - min
    }
}