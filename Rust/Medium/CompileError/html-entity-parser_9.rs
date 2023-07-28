impl Solution {
    pub fn entity_parser(text: String) -> String {
        
        let mut result = String::new();
        let mut chars = text.chars();
        while let Some(c) = chars.next() {
            match c {
                '&' => {
                    if let Some(next) = chars.next() {
                        match next {
                            'a' => {
                                if let Some(next) = chars.next() {
                                    match next {
                                        'm' => {
                                            if let Some(next) = chars.next() {
                                                match next {
                                                    'p' => {
                                                        if let Some(next) = chars.next() {
                                                            match next {
                                                                ';' => {
                                                                    result.push('&');
                                                                }
                                                                _ => {
                                                                    result.push('&');
                                                                    result.push('a');
                                                                    result.push('m');
                                                                    result.push('p');
                                                                    result.push(next);
                                                                }
                                                            }
                                                        }
                                                    }
                                                    _ => {
                                                        result.push('&');
                                                        result.push('a');
                                                        result.push('m');
                                                        result.push(next);
                                                    }
                                                }
                                            }
                                        }
                                        'p' => {
                                            if let Some(next) = chars.next() {
                                                match next {
                                                    'o' => {
                                                        if let Some(next) = chars.next() {
                                                            match next {
                                                                's' => {
                                                                    if let Some(next) = chars.next() {
                                                                        match next {
                                                                            ';' => {
                                                                                result.push('\'');
                                                                            }
                                                                            _ => {
                                                                                result.push('&');
                                                                                result.push('a');
                                                                                result.push('p');
                                                                                result.push('o');
                                                                                result.push('s');
                                                                                result.push(next);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                _ => {
                                                                    result.push('&');
                                                                    result.push('a');
                                                                    result.push('p');
                                                                    result.push(next);
                                                                }
                                                            }
                                                        }
                                                    }
                                                    _ => {
                                                        result.push('&');
                                                        result.push('a');
                                                        result.push(next);
                                                    }
                                                }
                                            }
                                        }
                                        _ => {
                                            result.push('&');
                                            result.push('a');
                                            result.push(next);
                                        }
                                    }
                                }
                            }
                            'g' => {
                                if let Some(next) = chars.next() {
                                    match next {
                                        't' => {
                                            if let Some(next) = chars.next() {
                                                match next {
                                                    ';' => {
                                                        result.push('>');
                                                    }
                                                    _ => {
                                                        result.push('&');
                                                        result.push('g');
                                                        result.push('t');
                                                        result.push(next);
                                                    }
                                                }
                                            }
                                        }
                                        _
    }
}