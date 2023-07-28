impl Solution {
    pub fn number_to_words(num: i32) -> String {
        
        let mut n = num;
        let mut words = vec![];
        let mut i = 0;
        while n > 0 {
            let r = n % 1000;
            if r > 0 {
                let mut s = Self::number_to_words_3(r);
                if i > 0 {
                    s.push_str(Self::unit(i).as_str());
                }
                words.push(s);
            }
            n /= 1000;
            i += 1;
        }
        if words.is_empty() {
            return "Zero".to_string();
        }
        words.reverse();
        words.join(" ")
    }
    fn number_to_words_3(n: i32) -> String {
        let mut n = n;
        let mut words = vec![];
        let mut i = 0;
        while n > 0 {
            let r = n % 10;
            if r > 0 {
                let mut s = Self::digit(r);
                if i > 0 {
                    s.push_str(Self::ten(i).as_str());
                }
                words.push(s);
            }
            n /= 10;
            i += 1;
        }
        if words.is_empty() {
            return "".to_string();
        }
        words.reverse();
        words.join(" ")
    }
    fn digit(n: i32) -> String {
        match n {
            1 => "One",
            2 => "Two",
            3 => "Three",
            4 => "Four",
            5 => "Five",
            6 => "Six",
            7 => "Seven",
            8 => "Eight",
            9 => "Nine",
            _ => "",
        }.to_string()
    }
    fn ten(n: i32) -> String {
        match n {
            1 => "Ten",
            2 => "Twenty",
            3 => "Thirty",
            4 => "Forty",
            5 => "Fifty",
            6 => "Sixty",
            7 => "Seventy",
            8 => "Eighty",
            9 => "Ninety",
            _ => "",
        }.to_string()
    }
}