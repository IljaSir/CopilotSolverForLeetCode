impl Solution {
    pub fn entity_parser(text: String) -> String {
        
        let mut result = String::new();
        let mut chars = text.chars();
        while let Some(c) = chars.next() {
            if c == '&' {
                if let Some(c) = chars.next() {
                    if c == 'a' {
                        if let Some(c) = chars.next() {
                            if c == 'm' {
                                if let Some(c) = chars.next() {
                                    if c == 'p' {
                                        if let Some(c) = chars.next() {
                                            if c == ';' {
                                                result.push('&');
                                                continue;
                                            }
                                        }
                                    }
                                }
                            } else if c == 'p' {
                                if let Some(c) = chars.next() {
                                    if c == 'o' {
                                        if let Some(c) = chars.next() {
                                            if c == 's' {
                                                if let Some(c) = chars.next() {
                                                    if c == ';' {
                                                        result.push('\'');
                                                        continue;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else if c == 'g' {
                        if let Some(c) = chars.next() {
                            if c == 't' {
                                if let Some(c) = chars.next() {
                                    if c == ';' {
                                        result.push('>');
                                        continue;
                                    }
                                }
                            }
                        }
                    } else if c == 'l' {
                        if let Some(c) = chars.next() {
                            if c == 't' {
                                if let Some(c) = chars.next() {
                                    if c == ';' {
                                        result.push('<');
                                        continue;
                                    }
                                }
                            }
                        }
                    } else if c == 'q' {
                        if let Some(c) = chars.next() {
                            if c == 'u' {
                                if let Some(c) = chars.next() {
                                    if c == 'o' {
                                        if let Some(c) = chars.next() {
                                            if c == 't' {
                                                if let Some(c) = chars.next() {
                                                    if c == ';' {
                                                        result.push('\"');
                                                        continue;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else if c == 'f' {
                        if let Some(c) = chars.next() {
                            if c == 'r' {
                                if let Some(c) = chars.next() {
                                    if c == 'a' {
                                        if let Some
    }
}