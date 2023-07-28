impl Solution {
    pub fn remove_kdigits(num: String, k: i32) -> String {
        

        let mut k = k;
        let mut num: Vec<char> = num.chars().collect();
        let mut i = 0;
        while k > 0 && i < num.len() - 1 {
            if num[i] > num[i + 1] {
                num.remove(i);
                if i > 0 {
                    i -= 1;
                }
                k -= 1;
            } else {
                i += 1;
            }
        }
        while k > 0 {
            num.pop();
            k -= 1;
        }
        let mut i = 0;
        while i < num.len() && num[i] == '0' {
            i += 1;
        }
        if i == num.len() {
            "0".to_string()
        } else {
            num[i..].iter().collect()
        }
    }
}