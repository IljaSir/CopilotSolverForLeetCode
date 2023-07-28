impl Solution {
    pub fn largest_time_from_digits(arr: Vec<i32>) -> String {
        
        let mut arr = arr;
        arr.sort_unstable();
        let mut res = String::new();
        for i in (0..4).rev() {
            for j in (0..4).rev() {
                if j == i {
                    continue;
                }
                for k in (0..4).rev() {
                    if k == i || k == j {
                        continue;
                    }
                    let l = 6 - i - j - k;
                    let h = arr[i] * 10 + arr[j];
                    let m = arr[k] * 10 + arr[l];
                    if h < 24 && m < 60 {
                        res = format!("{:02}:{:02}", h, m);
                        return res;
                    }
                }
            }
        }
        res
    }
}