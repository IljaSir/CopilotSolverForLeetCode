impl Solution {
    pub fn largest_time_from_digits(arr: Vec<i32>) -> String {
        
        let mut a = arr;
        a.sort();
        let mut res = String::new();
        for i in (0..4).rev() {
            for j in (0..4).rev() {
                if i == j { continue; }
                for k in (0..4).rev() {
                    if k == i || k == j { continue; }
                    let l = 6 - i - j - k;
                    if a[i] * 10 + a[j] < 24 && a[k] * 10 + a[l] < 60 {
                        res = format!("{}{}:{}{}", a[i], a[j], a[k], a[l]);
                        break;
                    }
                }
            }
        }
        res
    }
}