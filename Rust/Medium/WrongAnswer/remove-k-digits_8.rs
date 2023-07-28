impl Solution {
    pub fn remove_kdigits(num: String, k: i32) -> String {
        

        let mut num = num.chars().collect::<Vec<_>>();
        let mut k = k;
        let mut i = 0;
        while k > 0 {
            while i + 1 < num.len() && num[i] <= num[i + 1] {
                i += 1;
            }
            num.remove(i);
            if i > 0 {
                i -= 1;
            }
            k -= 1;
        }
        while num.len() > 1 && num[0] == '0' {
            num.remove(0);
        }
        num.into_iter().collect::<String>()
    }
}