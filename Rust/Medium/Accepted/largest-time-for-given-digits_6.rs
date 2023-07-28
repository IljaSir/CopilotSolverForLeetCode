impl Solution {
    pub fn largest_time_from_digits(arr: Vec<i32>) -> String {
        
        let mut a = arr;
        a.sort();
        let mut res = String::new();
        for i in (0..4).rev() {
            for j in (0..4).rev() {
                if i == j { continue; }
                for k in (0..4).rev() {
                    if k == j || k == i { continue; }
                    let l = 6 - i - j - k;
                    let hour = a[i] * 10 + a[j];
                    let min = a[k] * 10 + a[l];
                    if hour < 24 && min < 60 {
                        res = format!("{}{}:{}{}", a[i], a[j], a[k], a[l]);
                        return res;
                    }
                }
            }
        }
        res
    }
}