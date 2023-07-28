impl Solution {
    pub fn number_to_words(num: i32) -> String {
        
        if num == 0 {
            return "Zero".to_string();
        }
        let mut res = vec![];
        let mut num = num;
        let mut i = 0;
        while num > 0 {
            let v = num % 1000;
            if v > 0 {
                let s = Self::helper(v, i);
                res.push(s);
            }
            num /= 1000;
            i += 1;
        }
        res.reverse();
        res.join(" ")
    }
    
    fn helper(num: i32, i: i32) -> String {
        let mut res = vec![];
        let mut num = num;
        let mut i = i;
        let units = vec!["", "Thousand", "Million", "Billion"];
        let tens = vec!["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"];
        let teens = vec!["", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"];
        let ones = vec!["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"];
        while num > 0 {
            let v = num % 10;
            if i == 0 {
                res.push(ones[v as usize].to_string());
            } else if i == 1 {
                if v == 1 {
                    res.push(teens[res.pop().unwrap().parse::<usize>().unwrap()].to_string());
                } else {
                    res.push(tens[v as usize].to_string());
                }
            } else {
                res.push(ones[v as usize].to_string());
                res.push("Hundred".to_string());
            }
            num /= 10;
            i += 1;
        }
        res.reverse();
        res.retain(|x| !x.is_empty());
        res.push(units[i as usize].to_string());
        res.join(" ")
    }
}